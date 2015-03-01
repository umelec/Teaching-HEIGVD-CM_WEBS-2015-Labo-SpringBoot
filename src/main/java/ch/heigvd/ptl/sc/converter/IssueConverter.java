package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.to.IssueTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IssueConverter {

    public final List<IssueTO> convertSourceToTarget(List<Issue> sources) {
        List<IssueTO> results = new ArrayList<>();

        for (Issue source : sources) {
            results.add(convertSourceToTarget(source));
        }

        return results;
    }

    public final IssueTO convertSourceToTarget(Issue source) {
        IssueTO target = new IssueTO();
        fillTargetFromSource(target, source);
        return target;
    }

    public final List<Issue> convertTargetToSource(List<IssueTO> targets) {
        List<Issue> results = new ArrayList<>();

        for (IssueTO target : targets) {
            results.add(convertTargetToSource(target));
        }

        return results;
    }

    public final Issue convertTargetToSource(IssueTO target) {
        Issue source = new Issue();
        fillSourceFromTarget(source, target);
        return source;
    }

    public void fillTargetFromSource(IssueTO target, Issue source) {
        target.setId(source.getId());
        target.setAuthor(source.getAuthor());
        target.setIssueType(source.getIssueType());
        target.setDescription(source.getDescription());
        target.SetGeoCoordonnee(source.getGeoCoordonnee());
        target.SetStatus(source.getStatus());

    }

    public void fillSourceFromTarget(Issue source, IssueTO target) {
        source.setAuthor(target.getAuthor());
        source.setIssueType(target.getIssueType());
        source.setDescription(target.getDescription());
        source.setGeoCoordonnee(target.getGeoCoordonnee());
        source.setStatus(target.getStatus());

    }
}
